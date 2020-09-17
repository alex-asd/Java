namespace TrackPartClient
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxCarVIN = new System.Windows.Forms.TextBox();
            this.partsList = new System.Windows.Forms.ListBox();
            this.label2 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(38, 80);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(121, 17);
            this.label1.TabIndex = 0;
            this.label1.Text = "Input the car VIN :";
            // 
            // textBoxCarVIN
            // 
            this.textBoxCarVIN.Location = new System.Drawing.Point(165, 75);
            this.textBoxCarVIN.Name = "textBoxCarVIN";
            this.textBoxCarVIN.Size = new System.Drawing.Size(338, 22);
            this.textBoxCarVIN.TabIndex = 1;
            // 
            // partsList
            // 
            this.partsList.FormattingEnabled = true;
            this.partsList.ItemHeight = 16;
            this.partsList.Location = new System.Drawing.Point(41, 128);
            this.partsList.Name = "partsList";
            this.partsList.Size = new System.Drawing.Size(810, 244);
            this.partsList.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Arial", 7.8F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(38, 26);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(369, 16);
            this.label2.TabIndex = 3;
            this.label2.Text = "Please insert the car\'s VIN to see all the dispatched parts";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(509, 76);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 4;
            this.button1.Text = "Find";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(889, 394);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.partsList);
            this.Controls.Add(this.textBoxCarVIN);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Track Part";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBoxCarVIN;
        private System.Windows.Forms.ListBox partsList;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button button1;
    }
}

