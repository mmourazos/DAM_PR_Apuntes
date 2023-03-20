using ReservasMVVM.Modelo;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace ReservasMVVM.VistasModelos
{
    internal class VistaModeloListarReservas : VistaModeloBase
    {
        // No se debe hacer binding directamente al modelo. Por ello la colección será
        // de VistaModeloReserva en lugar de directamente de Reserva.
        private readonly ObservableCollection<VistaModeloReserva> _reservas;

        public IEnumerable<VistaModeloReserva> Reservas => _reservas;
        public ICommand HacerResreva { get; }

        public VistaModeloListarReservas()
        {
            _reservas = new ObservableCollection<VistaModeloReserva>();

            _reservas.Add(new VistaModeloReserva(new Reserva(new IDHabitacion(5, 110), "Manuel C.", DateTime.Now, DateTime.Now)));
            _reservas.Add(new VistaModeloReserva(new Reserva(new IDHabitacion(1, 11), "Manuel C.", DateTime.Now, DateTime.Now)));
            _reservas.Add(new VistaModeloReserva(new Reserva(new IDHabitacion(3, 10), "Manuel C.", DateTime.Now, DateTime.Now)));
            _reservas.Add(new VistaModeloReserva(new Reserva(new IDHabitacion(2, 1), "Manuel C.", DateTime.Now, DateTime.Now)));
        }
    }
}
