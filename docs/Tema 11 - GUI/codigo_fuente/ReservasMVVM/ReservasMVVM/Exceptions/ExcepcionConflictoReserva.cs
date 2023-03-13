using ReservasMVVM.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace ReservasMVVM.Exceptions
{
    internal class ExcepcionConflictoReserva : Exception
    {
        public Reserva ReservaExistente { get; }

        public Reserva NuevaReserva { get; }

        public ExcepcionConflictoReserva(Reserva reservaExistente, Reserva nuevaReserva)
        {
            ReservaExistente = reservaExistente;
            NuevaReserva = nuevaReserva;
        }

        public ExcepcionConflictoReserva(string message, Reserva reservaExistente, Reserva nuevaReserva) : base(message)
        {
            ReservaExistente = reservaExistente;
            NuevaReserva = nuevaReserva;
        }

        public ExcepcionConflictoReserva(string message, Exception innerException, Reserva reservaExistente, Reserva nuevaReserva) : base(message, innerException)
        {
            ReservaExistente = reservaExistente;
            NuevaReserva = nuevaReserva;
        }
    }
}
