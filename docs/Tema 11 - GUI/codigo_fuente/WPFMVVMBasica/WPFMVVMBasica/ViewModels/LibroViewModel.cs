using System.ComponentModel;
using System.Windows.Input;
using WPFMVVMBasica.Commands;
using WPFMVVMBasica.Model;

namespace WPFMVVMBasica.ViewModels
{
    internal class LibroViewModel : ViewModelBase
    {
        private readonly Libro _libro;

        public string Texto
        {
            get { return _libro.Texto; }

            set
            {
                _libro.Texto = value;
                OnPropertyChanged(nameof(Texto));
            }
        }

        private void ModelPropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            OnPropertyChanged(e.PropertyName);
        }

        public ICommand ComandoPasaAMayusculas { get; }
        public LibroViewModel(Libro libro)
        {
            _libro = libro;

            _libro.PropertyChanged += ModelPropertyChanged;

            ComandoPasaAMayusculas = new ComandoPasaAMayusculas(_libro);
        }
    }
}
