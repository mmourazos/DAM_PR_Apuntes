using AdivinaElNumero.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdivinaElNumero.VistasModelo
{
    internal class VistaModeloPartida : ViewModelBase
    {
        private readonly Partida _partida;
        public string Intentos => _partida.Intentos.ToString();
        public VistaModeloPartida(Partida partida)
        {
            _partida = partida;
        }
    }
}
