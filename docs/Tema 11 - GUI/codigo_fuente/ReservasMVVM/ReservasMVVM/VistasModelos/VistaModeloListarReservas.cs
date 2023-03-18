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
        private readonly ObservableCollection<VistaModeloReserva> _reservas;

        public IEnumerable<VistaModeloReserva> Reservas => _reservas;
        public ICommand HacerResreva { get; }

        public VistaModeloListarReservas()
        {
            _reservas = new ObservableCollection<VistaModeloReserva>();
        }
    }
}
