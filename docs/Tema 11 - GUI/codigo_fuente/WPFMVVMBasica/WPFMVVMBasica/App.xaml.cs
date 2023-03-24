using System.Windows;
using WPFMVVMBasica.Model;
using WPFMVVMBasica.ViewModels;

namespace WPFMVVMBasica
{
    /// <summary>
    /// Lógica de interacción para App.xaml
    /// </summary>
    public partial class App : Application
    {
        protected override void OnStartup(StartupEventArgs e)
        {
            MainWindow = new MainWindow()
            {
                // Establecemos la propiedad DataContext del objeto MainWindow.
                // Esto hará posible que la vista pueda "ver" las propiedades del DataContext (LibroViewModel)
                // y pueda hacer "binding" con ellas (TextBox a Texto y el Button al comando).
                DataContext = new LibroViewModel(new Libro("La razón de la sinrazón que a mi razón se hace."))
            };

            MainWindow.Show();

            base.OnStartup(e);
        }

    }
}
