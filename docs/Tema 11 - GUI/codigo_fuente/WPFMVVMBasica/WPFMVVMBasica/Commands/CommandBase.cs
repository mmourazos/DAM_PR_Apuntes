using System;
using System.Windows.Input;

namespace WPFMVVMBasica.Commands
{
    internal abstract class CommandBase : ICommand
    {
        public event EventHandler CanExecuteChanged;

        // En caso de que no se pudiese ejecutar el comando tendríamos 
        // que sobreescribir este método y hacer que devolviese false.
        public bool CanExecute(object parameter)
        {
            return true;
        }

        // Cada comando tendrá que escribir su Execute específico.
        public abstract void Execute(object parameter);

        protected void OnCanExecuteChanged()
        {
            CanExecuteChanged?.Invoke(this, EventArgs.Empty);
        }
    }
}
