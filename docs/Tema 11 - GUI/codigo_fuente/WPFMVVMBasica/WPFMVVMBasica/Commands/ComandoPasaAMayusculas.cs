using WPFMVVMBasica.Model;

namespace WPFMVVMBasica.Commands
{
    internal class ComandoPasaAMayusculas : CommandBase
    {
        private readonly Libro _libro;
        public ComandoPasaAMayusculas(Model.Libro libro)
        {
            _libro = libro;
        }

        public override void Execute(object parameter)
        {
            _libro.PasaAMayusculas();
        }
    }
}
