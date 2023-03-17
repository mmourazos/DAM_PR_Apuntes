using AdivinaElNumero.Modelo;
using AdivinaElNumero.VistasModelo;
using System;

namespace AdivinaElNumero.Comandos
{
    internal class ComandoPruebaNumero : CommandBase
    {
        private readonly Partida _partida;

        private readonly VistaModeloPartida _vMPartida;

        public ComandoPruebaNumero(VistaModeloPartida vMPartida, Partida partida)
        {
            _vMPartida = vMPartida;
            _partida = partida;
        }

        public override void Execute(object parameter)
        {
            throw new NotImplementedException();
            //_vMPartida.Intentos = _partida.Intento(_vMPartida.Numero);
        }
    }
}
