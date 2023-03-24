using System;

namespace Reservations.Modelo
{
    class Reserva
    { 

        public string IDCliente { get; }

        public IDHabitacion IDHabitacion { get; }

        public DateTime FechaEntrada { get; }

        public DateTime FechaSalida { get; }

        public TimeSpan TiempoEstancia { get
            {
                return FechaSalida - FechaEntrada;
            }
        }

        public bool HayConflicto (Reserva reserva)
        {
            if (IDHabitacion == reserva.IDHabitacion)
            {
                if ((reserva.FechaEntrada >= FechaEntrada && reserva.FechaEntrada <= FechaSalida) ||
                  (reserva.FechaSalida >= FechaEntrada && reserva.FechaSalida <= FechaSalida))
                {
                    return true;
                }
            }
            return false;
        }

        public Reserva(string iDCliente, IDHabitacion iDHabitacion, DateTime fechaEntrada, DateTime fechaSalida)
        {
            IDCliente = iDCliente;
            IDHabitacion = iDHabitacion;
            FechaEntrada = fechaEntrada;
            FechaSalida = fechaSalida;
        }
    }
}
