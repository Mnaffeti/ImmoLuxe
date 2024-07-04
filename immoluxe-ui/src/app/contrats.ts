
export class Contrat {
  id!: number;
  // idAgent!: number;
  // idClient!: number;
  // idProprietaire!: number;
  // idProperty!: Property;
  dateDebut!: Date;
  dateFin!: Date;
  typeContrat!: TypeContrat;
  montant!: number ;
  createdBy! :String  ;
  createdDate!: Date;
  /*Ajouter */
  proprietaire!: string;
  client!: string;
  adresse!: string;
  compose!: string;
  but!: string;
  description!: string;
  venteParagraph1!:boolean;
  venteParagraph2!:boolean;
  venteParagraph3!:boolean;
  locationParagraph1!:boolean;
  locationParagraph2!:boolean;
  locationParagraph3!:boolean;

  generalParagraph1!:boolean;
  generalParagraph2!:boolean;
  generalParagraph3!:boolean;
  generalParagraph4!:boolean;

  constructor() {
    /*this.idAgent = 0;
    this.idClient = 0;
    this.idProprietaire = 0;
    this.idProperty = new Property();*/
    this.dateDebut =  new Date();
    this.dateFin  =  new Date();
    this.createdDate =  new Date();
    this.typeContrat = TypeContrat.None;
    this.montant = 0;
    this.proprietaire="Douaa ZAOUI";
    this.client="Aziz NAFFETI";
    this.adresse="Tunis Arianna";
    this.compose="2 Chambres";
    this.but="Inconnu";
    this.description = "";
    this.venteParagraph1=false;
    this.venteParagraph2=false;
    this.venteParagraph3=false;
    this.locationParagraph1=false;
    this.locationParagraph2=false;
    this.locationParagraph3=false;

    this.generalParagraph1=false;
    this.generalParagraph2=false;
    this.generalParagraph3=false;
    this.generalParagraph4=false;
    /*this.hasEquipment = false;
    this.equipements = "";
    */
  }
}

export enum TypeContrat {
  None = '',
  Vente = 'Vente',
  Location = 'Location',
  Construction = 'Construction'
}
