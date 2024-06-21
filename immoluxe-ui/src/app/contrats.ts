import {Property} from './properties'
export class Contrat {
  idContrat !: number;
  idAgent!: number;
  idClient!: number;
  idProprietaire!: number;
  idProperty!: Property;
  dateDebut!: Date;
  dateFin!: Date;
  description!: string;
  hasEquipment!: boolean;
  equipements!: string;

  constructor() {
    this.idAgent = 0;
    this.idClient = 0;
    this.idProprietaire = 0;
    this.idProperty = new Property();
    this.dateDebut = new Date();
    this.dateFin = new Date();
    this.hasEquipment = false;
    this.equipements = "";
    this.description = "";
  }
}
