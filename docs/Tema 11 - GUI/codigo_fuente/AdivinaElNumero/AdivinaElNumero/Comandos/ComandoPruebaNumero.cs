using AdivinaElNumero.Modelo;
using AdivinaElNumero.VistasModelo;

namespace AdivinaElNumero.Comandos
{
    internal class ComandoPruebaNumero : CommandBase
    {
        private readonly Partida _partida;

        private readonly VistaModeloPartida _vMPartida;


        public override void Execute(object parameter)
        {
            _partida.Intento(_vMPartida.Numero);
        }
        public ComandoPruebaNumero(VistaModeloPartida vMPartida, Partida partida)
        {
            _vMPartida = vMPartida;
            _partida = partida;
        }
    }
}
