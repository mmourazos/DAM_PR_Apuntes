using MySql.Data.MySqlClient;
using System.Windows;

namespace TestConBDD.DBConn
{
    internal class DBConn
    {
        private string _server;

        public string Server { set { _server = value; } }

        private int _port;

        public int Port { set { _port = value; } }

        private string _database;

        public string Database { set { _server = value; } }

        private string _user;

        public string User { set { _user = value; } }

        private string _password;

        public string Password { set { _password = value; } }




        MySqlConnection conn = new MySqlConnection();

        public MySqlConnection Connection
        {
            get
            {
                try
                {

                    conn.ConnectionString = $"server={_server}; port={_port}; user id={_user}; password={_password}; database={_database};";
                    conn.Open();
                    return conn;

                }
                catch (MySqlException e)
                {

                    MessageBox.Show(e.ToString());
                }
            }
        }
    }
}
