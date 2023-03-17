using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace AdivinaElNumero.Comandos
{
    internal abstract class CommandBase : ICommand
    {
        public event EventHandler CanExecuteChanged;

        public virtual bool CanExecute(object parameter)
        {
            return true;
        }

        public abstract void Execute( object parameter);

        protected void OnCanExectueChanged() 
        {
            CanExecuteChanged?.Invoke(this, EventArgs.Empty); 
        }
        
    }
}
