import {Property} from './properties'
export class Contrat {
  id !: number;
 // idAgent!: number;
//  idClient!: number;
  //idProprietaire!: number;
  //idProperty!: Property;
  dateDebut!: Date;
  dateFin!: Date;
  typeContrat !: TypeContrat;
  montant!: number ;
  createdBy! :String  ;
  //description!: string;
 // hasEquipment!: boolean;
 // equipements!: string;

  constructor() {
    /*this.idAgent = 0;
    this.idClient = 0;
    this.idProprietaire = 0;
    this.idProperty = new Property();*/
    this.dateDebut = new Date();
    this.dateFin = new Date();
    this.typeContrat = 0;
    this.montant = 0;
   /* this.hasEquipment = false;
    this.equipements = "";
    this.description = "";*/
  }
}
 enum TypeContrat{
  Default , Appartement , House , Terrain
}
