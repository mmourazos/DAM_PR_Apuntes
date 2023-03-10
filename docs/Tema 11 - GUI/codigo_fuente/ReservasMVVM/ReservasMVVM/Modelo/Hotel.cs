using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReservasMVVM.Modelo
{
    internal class Hotel
    {
        public string Nombre { get; set; }

        private readonly LibroDeReservas _libroDeReservas;

        public Hotel(string nombre)
        {
            Nombre = nombre;
            _libroDeReservas = new LibroDeReservas();
        }
    }
}
