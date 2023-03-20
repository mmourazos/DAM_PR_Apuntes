using AdivinaElNumero.Modelo;
using AdivinaElNumero.VistasModelo;

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
            _partida.NuevaPartida(int.Parse(_vMPartida.Min), int.Parse(_vMPartida.Max));
        }

        public ComandoNuevaPartida(Partida partida, VistaModeloPartida vMPartida)
        {
            _partida = partida;
            _vMPartida = vMPartida;
        }
    }
}
