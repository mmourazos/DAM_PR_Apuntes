using ReservasMVVM.Modelo;
using System.Collections.Generic;

namespace Reservations.Modelo
{
    class Hotel
    {
        /// <summary>
        /// Nombre del hotel.
        /// </summary>
        public string Nombre { get; set; }

        /// <summary>
        /// Listado de las reservas realizadas en el hotel.
        /// </summary>
        private LibroDeReservas _libroDeReservas;

        /// <summary>
        /// Devuelve todas las reservas realizadas en el hotel.
        /// </summary>
        /// <returns>Las resservas que hay en el hotel.</returns>
        public IEnumerable<Reserva> Reservas()
        {
            return _libroDeReservas.Reservas();
        }

        /// <summary>
        /// Devuelve las reservas realizadas por un cliente.
        /// </summary>
        /// <param name="idCliente">El identificador del cliente.</param>
        /// <returns>Las reservas asociadas al cliente.</returns>
        public IEnumerable<Reserva> ReservasCliente(string idCliente)
        {
            return _libroDeReservas.ReservasCliente(idCliente);
        }

        /// <summary>
        /// Constructor del hotel.
        /// </summary>
        /// <param name="nombre"> Nombre del hotel. </param>
        public Hotel(string nombre)
        {
            Nombre = nombre;
            _libroDeReservas = new LibroDeReservas();
        }
    }
}
