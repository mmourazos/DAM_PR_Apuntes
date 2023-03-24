using System.Windows;

namespace AdivinaElNumero.Comandos
{
    internal class ComandoCerrarAplicacion
    {
        public void Execute(object parameter)
        {
            Application.Current.Shutdown();
        }
    }
}
