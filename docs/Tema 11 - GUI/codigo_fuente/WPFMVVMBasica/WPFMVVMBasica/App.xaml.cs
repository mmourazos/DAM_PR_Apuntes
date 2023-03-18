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
                DataContext = new MainViewModel()
            };

            MainWindow.Show();

            base.OnStartup(e);
        }

    }
}
