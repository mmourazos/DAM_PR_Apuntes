using ReservasMVVM.VistasModelos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReservasMVVM.Stores
{
    internal class NavigationStore
    {
        private VistaModeloBase _currentViewModel;
        public VistaModeloBase CurrentViewModel
        {
            get { return _currentViewModel; }
            set { _currentViewModel = value; }
        }
    }
}
