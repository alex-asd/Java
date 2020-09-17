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
using System.Web.Script.Serialization;

namespace FacilityClient
{
    public partial class Form1 : Form
    {
        private List<Part> parts;
        public Form1()
        {
            InitializeComponent();
            parts = new List<Part>();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                parts.Add(new Part(Convert.ToString(partNameTextBox.Text), Convert.ToDouble(partWeightTextBox.Text)));
                partList.Items.Add(Convert.ToString(partNameTextBox.Text + " " + partWeightTextBox.Text + " ( kg )"));
            }
            catch(Exception ee)
            {
                MessageBox.Show("Please check whole the information, missing or invalid data was detected.", "Invalid or Missing Data", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int carYear;
            string carVin;
            string carMake;
            string carModel;
            double carWeight;

            ServiceReference1.LocalServerClient localServer = new ServiceReference1.LocalServerClient();
            
            try
            {
                carVin = Convert.ToString(carVINTextBox.Text);
                carYear = Convert.ToInt32(carYearTextBox.Text);
                carMake = Convert.ToString(carMakeTextBox.Text);
                carModel = Convert.ToString(carModelTextBox.Text);
                carWeight = Convert.ToDouble(carWeightTextBox.Text);

                foreach (Part part in parts) part.CarVIN = carVin;

                string jsonParts = Newtonsoft.Json.JsonConvert.SerializeObject(parts).ToString();

                bool b = localServer.registerCar(carVin, carModel, carMake, carYear, carWeight, jsonParts);

                if (!b) throw new Exception();
                
                MessageBox.Show("Car registered succesfully", "Succesful registration", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            catch(Exception ee)
            {
                Console.WriteLine(ee);

                MessageBox.Show("Please check whole the information, missing or invalid data was detected.", "Invalid or Missing Data", MessageBoxButtons.OK, MessageBoxIcon.Error);

            }
        }
    }
}
