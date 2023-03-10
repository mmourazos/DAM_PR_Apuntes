using System.Collections.Generic;

namespace ReservasMVVM.Modelo
{

    internal class LibroDeReservas
    {
        private readonly Dictionary<IDHabitacion,  List<Reserva>> _habitacionsAReservas;

        public LibroDeReservas()
        {
            _habitacionsAReservas = new Dictionary<IDHabitacion, List<Reserva>>();
        }
    }
}
