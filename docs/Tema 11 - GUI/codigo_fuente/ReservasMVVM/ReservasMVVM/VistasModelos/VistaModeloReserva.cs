using ReservasMVVM.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReservasMVVM.VistasModelos
{
    internal class VistaModeloReserva : VistaModeloBase
    {
        private readonly Reserva _reserva;

        public string IDHabitacion => _reserva.IDHabitacion?.ToString();

        public string IDCliente => _reserva.IDCliente;

        public DateTime FechaDeEntrada => _reserva.FechaEntrada;

        public DateTime FechaDeSalida => _reserva.FechaSalida;

        public VistaModeloReserva(Reserva reserva)
        {
            _reserva = reserva;
        }
    }
}
