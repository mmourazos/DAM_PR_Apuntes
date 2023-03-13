using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReservasMVVM.Modelo
{
    internal class Hotel
    {
        /// <summary>
        /// Nombre del hotel.
        /// </summary>
        public string Nombre { get; set; }

        /// <summary>
        /// Lista de reservas del hotel.
        /// </summary>
        private readonly LibroDeReservas _libroDeReservas;

        /// <summary>
        /// Devuelve las reservas creadas por un cliente.
        /// </summary>
        /// <param name="idUsuario">El identificador del usuario.</param>
        /// <returns>Las reservas encontradas para dicho usuario.</returns>
        public IEnumerable<Reserva> ReservasCliente(string idUsuario)
        {
            return _libroDeReservas.ReservasCliente(idUsuario);
        }

        public IEnumerable<Reserva> Reservas()
        {
            return _libroDeReservas.Reservas();
        }

        /// <summary>
        /// Añade una reserva a la lista de reservas.
        /// </summary>
        /// <param name="reserva"></param>
        /// <exception cref="ExcepcionConflictoReserva"></exception>
        public void HacerReserva(Reserva reserva)
        {
            _libroDeReservas.HacerReserva(reserva);
        }

        /// <summary>
        /// Constructor del hotel.
        /// </summary>
        /// <param name="nombre">El nombre del hotel.</param>
        public Hotel(string nombre)
        {
            Nombre = nombre;
            _libroDeReservas = new LibroDeReservas();
        }
    }
}
