using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReservasMVVM.VistasModelos
{
    internal class VistaModeloPrincipal : VistaModeloBase
    {
        public VistaModeloBase VistaModeloActual { get; }

        public VistaModeloPrincipal()
        {
            VistaModeloActual = new VistaModeloHacerReserva();
        }
    }
}
