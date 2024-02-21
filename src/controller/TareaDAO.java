/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Tarea;
import utils.Conexion;
import java.sql.ResultSet;

public class TareaDAO {

    private Connection conecta = null;

    public ResultSet ConsultarTareas() {
        ResultSet rs = null;

        try {
            Connection con = Conexion.getConnection();
            String sql = "SELECT * FROM task";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Realizar cualquier operación adicional con el ResultSet si es necesario
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return rs;
    }

    public void insertarTareas(Tarea tarea) {
        PreparedStatement ps = null;
        try {
            if (conecta == null) {
                conecta = Conexion.getConnection();
            }

            ps = conecta.prepareStatement("INSERT INTO task (tarea, descripcion, fechaCreacion, fechaFin, categoria, prioridad, tiempo) VALUES (?,?,?,?,?,?,?)");

            ps.setString(1, tarea.getTarea());
            ps.setString(2, tarea.getDescripcion());
            ps.setString(3, tarea.getFechaCreacion());
            ps.setString(4, tarea.getFechaFin());
            ps.setString(5, tarea.getCategoria());
            ps.setInt(6, tarea.getPrioridad());
            ps.setInt(7, tarea.getTiempo());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "¡El registro fue agregado exitosamente!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void actualizarTarea(Tarea tarea, String id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();

            ps = conn.prepareStatement("UPDATE task SET tarea=?, descripcion=?, fechaCreacion=?, fechaFin=?, categoria=?, prioridad=?, tiempo=? WHERE id=?");

            ps.setString(1, tarea.getTarea());
            ps.setString(2, tarea.getDescripcion());
            ps.setString(3, tarea.getFechaCreacion());
            ps.setString(4, tarea.getFechaFin());
            ps.setString(5, tarea.getCategoria());
            ps.setInt(6, tarea.getPrioridad());
            ps.setInt(7, tarea.getTiempo());
            ps.setString(8, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "¡El registro fue actualizado exitosamente!");
            } else {
                System.out.println("Error al actualizar");
            }
        } catch (Exception ex) {
            System.out.println("Error al actualizar: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void eliminarTarea(String id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();

            // Verifica si el ID de la tarea está presente antes de intentar la eliminación
            if (id != null && !id.isEmpty()) {
                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar esta tarea?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    ps = conn.prepareStatement("DELETE FROM task WHERE id=?");
                    ps.setString(1, id);

                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "¡El registro fue eliminado exitosamente!");
                    } else {
                        System.out.println("Error al eliminar");
                    }
                }
            } else {
                // Si el ID está vacío, significa que no hay ninguna tarea seleccionada para eliminar
                JOptionPane.showMessageDialog(null, "¡Selecciona una tarea para eliminar!");
            }
        } catch (Exception ex) {
            System.out.println("Error al eliminar: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Tarea obtenerTareaPorId(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Tarea tarea = null;

        try {
            conn = Conexion.getConnection();

            ps = conn.prepareStatement("SELECT * FROM task WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                tarea = new Tarea(
                        rs.getString("tarea"),
                        rs.getString("descripcion"),
                        rs.getString("fechaCreacion"),
                        rs.getString("fechaFin"),
                        rs.getString("categoria"),
                        rs.getInt("prioridad"),
                        rs.getInt("tiempo")
                );
                tarea.setId(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return tarea;
    }
}//cierra class
