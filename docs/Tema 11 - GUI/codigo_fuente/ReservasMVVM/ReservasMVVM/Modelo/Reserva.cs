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

        public Reserva(IDHabitacion idHabitacion, DateTime fechaEntrada, DateTime fechaSalida)
        {
            IDHabitacion = idHabitacion;
            FechaEntrada = fechaEntrada;
            FechaSalida = fechaSalida;
        }
    }
}
