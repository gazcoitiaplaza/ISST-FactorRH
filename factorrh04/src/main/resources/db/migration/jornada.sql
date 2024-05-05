INSERT INTO Jornadas (
    idEmpleado, fecha, hora_entrada, hora_salida, entrada_teorica,
    salida_teorica, minutos_trabajados, minutos_teoricos, saldo,
    incidencia, estado, notas
)
VALUES
    ('001', '2024-05-01', '08:00:00', '16:00:00', '08:00:00', '16:00:00', 480, 480, 0, 'N/A', 'OK', 'Dia normal'),
    ('001', '2024-05-02', '08:30:00', '16:30:00', '08:00:00', '16:00:00', 480, 480, 0, 'N/A', 'OK', 'Dia con retraso'),
    ('001', '2024-05-03', '08:00:00', '15:00:00', '08:00:00', '16:00:00', 420, 480, -60, 'N/A', 'RT', 'Salida anticipada'),
    ('001', '2024-05-04', '09:00:00', '17:00:00', '08:00:00', '16:00:00', 480, 480, 0, 'N/A', 'OK', 'Dia normal con retraso'),
    ('001', '2024-05-05', '08:00:00', '16:00:00', '08:00:00', '16:00:00', 480, 480, 0, 'N/A', 'OK', 'Dia normal');
