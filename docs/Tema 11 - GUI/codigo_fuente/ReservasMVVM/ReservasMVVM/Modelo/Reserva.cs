using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReservasMVVM.Modelo
{
    internal class Reserva
    {
        public IDHabitacion IDHabitacion { get; }

        public string IDCliente { get; }

        public DateTime FechaEntrada { get; }

        public DateTime FechaSalida { get; }

        public TimeSpan DuracionEstancia => FechaSalida - FechaEntrada;

        //public TimeSpan DuracionEstancia
        //{
        //    get
        //    {
        //        return FechaSalida - FechaEntrada;
        //    }
        //}

        public bool Conflicto(Reserva reserva)
        {
            if (IDHabitacion != reserva.IDHabitacion) return false;
            if ((reserva.FechaEntrada >= FechaEntrada && reserva.FechaEntrada <= FechaSalida) ||
                   (reserva.FechaSalida >= FechaEntrada && reserva.FechaSalida <= FechaSalida ))
            {
                return true;
            }
            return false;
        }

        public Reserva(IDHabitacion idHabitacion, string idCliente, DateTime fechaEntrada, DateTime fechaSalida)
        {
            IDHabitacion = idHabitacion;
            IDCliente = idCliente;
            FechaEntrada = fechaEntrada;
            FechaSalida = fechaSalida;
        }
    }
}
