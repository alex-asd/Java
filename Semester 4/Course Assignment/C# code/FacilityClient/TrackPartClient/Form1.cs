using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using ClassLibrary;

namespace TrackPartClient
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBoxCarVIN.Text.Length >= 8)
            {
                ServiceReference1.LocalServerClient localServer = new ServiceReference1.LocalServerClient();

                partsList.Items.Clear();

                try
                {
                    string stringJsonArray = localServer.trackPart(textBoxCarVIN.Text);

                    if (stringJsonArray.Equals("-1")) throw new Exception();
                    if (stringJsonArray.Equals("[]")) MessageBox.Show("No car with such VIN number", "No car with such VIN", MessageBoxButtons.OK, MessageBoxIcon.Information);

                    JArray jsonArray = JArray.Parse(stringJsonArray);

                    for (int i = 0; i < jsonArray.Count; i++)
                    {
                        PartDestination partDestination = jsonArray[i].ToObject<PartDestination>();

                        if (!partDestination.receiverName.Equals("In the warehouse"))
                        {
                            partsList.Items.Add(partDestination.partType);
                            partsList.Items.Add("   Receiver Name : " + partDestination.receiverName);
                            partsList.Items.Add("   Receiver Address : " + partDestination.receiverAddress);
                            partsList.Items.Add("   Receiver Country : " + partDestination.receiverCountry);
                            partsList.Items.Add("");
                        }
                        else
                            partsList.Items.Add(partDestination.partType + " - " + partDestination.receiverName);
                    }
                }
                catch (Exception ee)
                {
                    MessageBox.Show("An error was encountered", "ERROR", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
            else
                MessageBox.Show("The car VIN has to be at least 8 characters long", "Information", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
    }
}
