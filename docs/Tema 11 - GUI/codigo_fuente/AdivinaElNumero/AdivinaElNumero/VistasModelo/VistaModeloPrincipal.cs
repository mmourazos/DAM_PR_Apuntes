using AdivinaElNumero.VistasModelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdivinaElNumero.VistasModelo
{
    internal class VistaModeloPrincipal : ViewModelBase
    {
        public ViewModelBase VistaModeloActual { get; }

        public VistaModeloPrincipal()
        {
            VistaModeloActual = new VistaModeloPartida(new Modelo.Partida(0, 100));
        }
    }
}
