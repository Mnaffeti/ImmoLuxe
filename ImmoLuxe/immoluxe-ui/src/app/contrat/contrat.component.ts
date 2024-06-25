import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from "@angular/forms";
import {Contrat} from '../contrats'
import {contratService} from '../contrat.service';
import { jsPDF } from 'jspdf';
@Component({
  selector: 'app-contrat',
  templateUrl: './contrat.component.html',
  styleUrls: ['./contrat.component.css']
})
export class ContratComponent {

  constructor(
    private contratService :contratService,
    private route: ActivatedRoute,
    private router : Router

  ) {

  }


  submitform!: NgForm;
  private baseURL = "http://localhost:8080/api/v1/contrat";
  contrat: Contrat = new Contrat();

  ngOnInit(): void {
    this.contrat.id = this.route.snapshot.params['id'];

    this.contratService.getContratById(this.contrat.id).subscribe(data => {
      this.contrat = data;
    }, error => console.log(error));
  }
  onSubmit() {
    console.log(this.contrat);
    this.saveProperty();
  }
  saveProperty() {
    this.contratService.addContrat(this.contrat).subscribe(data => {
        console.log(data);
        console.log('goToPropertyList...');
        this.goToPropertyList();

      },
      error => console.log(error));
  }
  goToPropertyList() {
    this.router.navigate(['/show-all-contrats']);
    console.log('gIn PropertyList...');
    this.generatePdf();
  }

  generatePdf(): void {

  //  this.onSubmit();


    console.log('Generating PDF...');
   // if (window.confirm('Are you sure you want to generate the PDF?')) {
      const doc = new jsPDF();

      // Add title
      doc.setFont('helvetica', 'bolditalic');
      doc.setFontSize(24);
    doc.text(`CONTRACT DE ${this.contrat.typeContrat}`.toUpperCase(), 50, 20);

      /*Date de creation*/
    doc.setFont('helvetica', 'normal');
    doc.setFontSize(10);
    doc.text('Tunis le : ', 5, 5);
    const createDate = new Date(this.contrat.createdDate);
    const formattedDate = createDate.toLocaleDateString('fr-FR', {
      year: 'numeric',
      month: '2-digit',
      day: '2-digit'
    }).replace(/\//g, '-');
    doc.text(` ${formattedDate}`, 15, 5);

      // Add contract details in two columns
      const columnWidth = 90;
      const columnMargin = 10;
      const leftColumnX = 10;
      const rightColumnX = leftColumnX + columnWidth + columnMargin;
      /*      doc.setFontSize(14);
      doc.setFont('helvetica', 'bolditalic');
      doc.text('Id Agent:', leftColumnX, 60);
      doc.setFont('helvetica', 'normal');
      doc.setFontSize(12);
      doc.text(` ${this.contrat.createdBy}`, rightColumnX, 60);*/
   // Section 1 : M.(s)
    doc.setFontSize(15);
    doc.setFont('helvetica', 'bolditalic');
    doc.text('Section 1 : ', leftColumnX, 40);
    doc.setFontSize(12);
    doc.setFont('helvetica', 'normal');
    doc.text('M.(s) ${this.contrat.proprietaire}', leftColumnX, 40);
    doc.text(` `, rightColumnX, 60);

   /*   doc.setFontSize(14);
      doc.setFont('helvetica', 'bolditalic');
      doc.text('Id Proprietaire:', leftColumnX, 50);
      doc.setFont('helvetica', 'normal');
      doc.setFontSize(12);
      doc.text(` ${this.contrat.idProprietaire}`, rightColumnX, 50);


      doc.setFontSize(14);
      doc.setFont('helvetica', 'bolditalic');
      doc.text('Id Client:', leftColumnX, 60);
      doc.setFont('helvetica', 'normal');
      doc.setFontSize(12);
      doc.text(` ${this.contrat.idClient}`, rightColumnX, 60);

      doc.setFontSize(14);
      doc.setFont('helvetica', 'bolditalic');
      doc.text('Id Property:', leftColumnX, 70);
      doc.setFont('helvetica', 'normal');
      doc.setFontSize(12);
      doc.text(` ${this.contrat.idProperty}`, rightColumnX, 70);





      doc.setFontSize(14);
      doc.setFont('helvetica', 'bolditalic');
      doc.text('Address:', leftColumnX, 90);
      doc.setFontSize(12);
      doc.setFont('helvetica', 'normal');
      doc.text(` ${this.contrat.idProperty.address}`, rightColumnX, 90);


      doc.setFontSize(14);
      doc.setFont('helvetica', 'bolditalic');
      doc.text('Area:', leftColumnX, 100);
      doc.setFontSize(12);
      doc.setFont('helvetica', 'normal');
      doc.text(` ${this.contrat.idProperty.area}`, rightColumnX, 100);*/


      doc.setFontSize(14);
      doc.setFont('helvetica', 'bolditalic');
      doc.text('Date Debut:', leftColumnX, 50);
      doc.setFontSize(12);
      doc.setFont('helvetica', 'normal');
      doc.text(` ${this.contrat.dateDebut}`, rightColumnX, 50);


      doc.setFontSize(14);
      doc.setFont('helvetica', 'bolditalic');
      doc.text('Date Fin:', leftColumnX, 60);
      doc.setFontSize(12);
      doc.setFont('helvetica', 'normal');
      doc.text(` ${this.contrat.dateFin}`, rightColumnX, 60);

      doc.setFontSize(14);
      doc.setFont('helvetica', 'bolditalic');
      doc.text('Contrat Type:', leftColumnX, 70);
      doc.setFont('helvetica', 'normal');
      doc.setFontSize(12);
      doc.text(` ${this.contrat.typeContrat}`, rightColumnX, 70);

      doc.setFontSize(14);
      doc.setFont('helvetica', 'bolditalic');
      doc.text('Montant:', leftColumnX, 80);
      doc.setFont('helvetica', 'normal');
      doc.setFontSize(12);
      doc.text(` ${this.contrat.montant}`, rightColumnX, 80);
      // Add equipment details if applicable
    /*  if (this.contrat.hasEquipment === true) {
        doc.setFontSize(14);
        doc.setFont('helvetica', 'bolditalic');
        doc.text('Equipment Details:', leftColumnX, 130);
        doc.setFontSize(14);
        doc.setFont('helvetica', 'bolditalic');
        doc.text(` Équipements: `, 15, 140);
        doc.setFontSize(12);
        doc.setFont('helvetica', 'normal');
        doc.text(` ${this.contrat.equipements}`, 15, 140);
      } else {
        doc.setFontSize(14);
        doc.setFont('helvetica', 'bolditalic');
        doc.text('Equipements :', leftColumnX, 130);
        doc.setFontSize(12);
        doc.setFont('helvetica', 'normal');
        doc.text(`Non`, rightColumnX, 130);
      }*/

      // Add N_appart_Totale and N_appart_To_have details if applicable
     /* if (this.contrat.idProperty.type === 'Appartement') {
        doc.setFontSize(14);
        doc.setFont('helvetica', 'bolditalic');
        doc.text('Appartement Details:', leftColumnX, 150);


        doc.setFontSize(14);
        doc.setFont('helvetica', 'bolditalic');
        doc.text(`N_appart_Totale: `, 15, 160);
        doc.setFontSize(12);
        doc.setFont('helvetica', 'normal');
        doc.text(`${this.contrat.idProperty.type}`, 15, 160);


        doc.setFontSize(14);
        doc.setFont('helvetica', 'bolditalic');
        doc.text(`N_appart_To_have: `, leftColumnX, 170);
        doc.setFontSize(12);
        doc.setFont('helvetica', 'normal');
        doc.text(`${this.contrat.idProperty.type}`, 15, 170);
      }*/
   /*   if (this.contrat.idProperty.type === 'House') {
        doc.setFontSize(14);
        doc.setFont('helvetica', 'bolditalic');
        doc.text('Maison Details:', leftColumnX, 120);
        doc.text(`N_bathrooms: `, leftColumnX, 130);
        doc.setFontSize(12);
        doc.setFont('helvetica', 'normal');
        doc.text(`${this.contrat.idProperty.bathrooms}`, rightColumnX, 130);
        doc.text(`N_bedrooms: `, leftColumnX, 140);
        doc.setFontSize(12);
        doc.setFont('helvetica', 'normal');
        doc.text(`${this.contrat.idProperty.bedrooms}`, rightColumnX, 140);
      }*/
     /* if (this.contrat.idProperty.type === 'Terrain') {
        doc.setFontSize(14);
        doc.setFont('helvetica', 'bolditalic');
        doc.text('Terrain Details:', leftColumnX, 120);
        doc.text(`N_appart_Totale: `, leftColumnX, 130);
        doc.setFontSize(12);
        doc.setFont('helvetica', 'normal');
        doc.text(`${this.contrat.nAppartTotal}`, rightColumnX, 130);
        doc.text(`N_appart_To_have: `, leftColumnX, 140);
        doc.setFontSize(12);
        doc.setFont('helvetica', 'normal');
        doc.text(`${this.contrat.nAppartToHave}`, rightColumnX, 140);
      }*/

      // Generate the PDF blob
      const pdfBlob = doc.output('blob');

      // Create a URL for the PDF blob
      const pdfUrl = URL.createObjectURL(pdfBlob);

      // Create a link to download the PDF file
      const link = document.createElement('a');
      link.href = pdfUrl;
      link.download = `Contract.pdf`;
      link.click();

      // Clean up
      URL.revokeObjectURL(pdfUrl);

    }

  // this.goToPropertyList();
  //}
}
