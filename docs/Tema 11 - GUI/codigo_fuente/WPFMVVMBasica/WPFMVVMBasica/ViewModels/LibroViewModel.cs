using System.ComponentModel;
using System.Windows.Input;
using WPFMVVMBasica.Commands;
using WPFMVVMBasica.Model;

namespace WPFMVVMBasica.ViewModels
{
    internal class LibroViewModel : ViewModelBase
    {
        private readonly Libro _libro;
        private int _pagina;

        public string Texto
        {
            get { return _libro.Texto; }

            set
            {
                _libro.Texto = value;
                // Avisamos a la vista (bueno, a nuestros subscriptores) de que Texto
                // ha cambiado.
                OnPropertyChanged(nameof(Texto));
            }
        }

        public int NPagina
        {
            get { return _pagina; }

            set
            {
                _pagina = value;
                OnPropertyChanged(nameof(NPagina));
            }
        }

        public int NPagina
        {
            get { return _pagina; }

            set
            {
                _pagina = value;
                OnPropertyChanged(nameof(NPagina));
            }
        }

        // Cuando nos avise (el modelo) de que ha cambiado el valor de alguna
        // de sus propiedades (el caso de Texto) avisamos a la vista (que habrá hecho
        // "bindings" a nuestras propiedades) de que ha cambiado el valor de alguna propiedad.
        // En nuestro caso la única propiedad de la que nos interesa avisar es Texto
        private void ModelPropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            OnPropertyChanged(nameof(Texto));
        }

        public ICommand ComandoPasaAMayusculas { get; }

        public LibroViewModel(Libro libro)
        {
            _libro = libro;

            // Nos subscribimos al evento "PropertyChanged" del Modelo (_libro) para que nos
            // avise si cambia el texto y así podamos avisar a su vez a la vista.
            _libro.PropertyChanged += ModelPropertyChanged;

            // Asignamos un comando a la propiedad ComandoPasaAMayusculas al que se habrá
            // conectado (vía "Binding") el botón.
            ComandoPasaAMayusculas = new ComandoPasaAMayusculas(_libro);
        }
    }
}
