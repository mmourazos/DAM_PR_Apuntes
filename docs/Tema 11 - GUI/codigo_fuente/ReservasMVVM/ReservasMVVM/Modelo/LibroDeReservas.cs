using ReservasMVVM.Exceptions;
using System;
using System.Collections.Generic;
using System.Linq;

namespace ReservasMVVM.Modelo
{

    internal class LibroDeReservas
    {
        private readonly List<Reserva> _reservas;

        public LibroDeReservas()
        {
            _reservas = new List<Reserva>();
        }

        public IEnumerable<Reserva> ReservasCliente(string idCliente)
        {
            return _reservas.Where<Reserva>(reserva => reserva.IDCliente == idCliente);
        }

        public IEnumerable<Reserva> ReservasFecha(DateTime fecha)
        {
            return _reservas.Where(reserva => fecha >= reserva.FechaEntrada && fecha <= reserva.FechaSalida);
        }

        private bool HayConflictoFecha(DateTime fecha, Reserva reserva)
        {
            if (fecha > reserva.FechaSalida || fecha < reserva.FechaEntrada) return false;
            return true;
        }

        private bool FechaOcupada(DateTime fecha)
        {
            foreach (Reserva reserva in _reservas)
            {
                if (HayConflictoFecha(fecha, reserva)) return true;
            }
            return false;
        }

        private Reserva HayConflictoReserva(Reserva reserva)
        {
            foreach (var r in _reservas)
            {
                if (reserva.Conflicto(r)) return r;
            }
            return null;
        }

        public void HacerReserva(Reserva reserva)
        {
            Reserva reservaExistente;
            if ((reservaExistente = HayConflictoReserva(reserva)) != null)
            {
                throw new ExcepcionConflictoReserva(reservaExistente, reserva);
            } else
            {
                _reservas.Add(reserva);
            }
        }
    }
}
