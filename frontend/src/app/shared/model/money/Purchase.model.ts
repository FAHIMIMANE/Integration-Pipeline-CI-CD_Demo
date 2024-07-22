import {PurchaseItemDto} from './PurchaseItem.model';
import {ClientDto} from '../crm/Client.model';

import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PurchaseDto extends BaseDto{

    public reference: string;

   public purchaseDate: Date;

    public image: string;

    public total: null | number;

    public description: string;

    public client: ClientDto ;
     public purchaseItems: Array<PurchaseItemDto>;


    constructor() {
        super();

        this.reference = '';
        this.purchaseDate = null;
        this.image = '';
        this.total = null;
        this.description = '';
        this.purchaseItems = new Array<PurchaseItemDto>();

        }

}
