import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { Material } from "../shared/material";
import { RouterModule } from "@angular/router";
import { dashboardRoutes } from "./dashboard.routing";
import { DashboardComponent } from "./dashboard.component";
//import { FlexLayoutModule } from '@angular/flex-layout';
@NgModule({
    imports:[
        CommonModule,
        Material,
        RouterModule.forChild(dashboardRoutes)
        

    ],
    declarations:[DashboardComponent]

})

export class DashboardModule{};