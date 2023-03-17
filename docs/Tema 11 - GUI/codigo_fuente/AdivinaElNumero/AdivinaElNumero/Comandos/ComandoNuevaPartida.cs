using AdivinaElNumero.Modelo;
using AdivinaElNumero.VistasModelo;
using System;

namespace AdivinaElNumero.Comandos
{
    internal class ComandoNuevaPartida : CommandBase
    {
        private readonly Partida _partida;
        private readonly VistaModeloPartida _vMPartida;

        public ComandoNuevaPartida(VistaModeloPartida vMPartida, Partida partida)
        {
            _partida = partida;
            _vMPartida = vMPartida;
        }

        public override void Execute(object parameter)
        {
            throw new NotImplementedException();
            //_partida.NuevaPartida(_vMPartida.Min, _vMPartida.Max);
            //_vMPartida.Intentos = 0;
        }
    }
}
