'use strict';

/* Controllers */

function ArticleListCtrl($scope) {
	$scope.brands = [{
		"id" : "1",
		"nom" : "Raquettes"
	},{
		"id" : "2",
		"nom" : "Chaussures"
	},{
		"id" : "3",
		"nom" : "Balles"
	}]
	$scope.article = [ {
		"nom" : "Babola Storm II",
		"reference" : "BABSII",
		"price" : "125.5",
		"description" : "La dernière raquette de babolat",
		"brand" : {
			"nom" : "Babolat",
			"description" : "Equipementier Français"
		},
		"deal" : {},
		"reviews" : {}
	}, {
		"nom" : "Babola Storm II",
		"reference" : "BABSII",
		"price" : "125.5",
		"description" : "La dernière raquette de babolat",
		"brand" : {
			"nom" : "Babolat",
			"description" : "Equipementier Français"
		},
		"deal" : {},
		"reviews" : {}
	}, {
		"nom" : "Babola Storm II",
		"reference" : "BABSII",
		"price" : "125.5",
		"description" : "La dernière raquette de babolat",
		"brand" : {
			"nom" : "Babolat",
			"description" : "Equipementier Français"
		},
		"deal" : {},
		"reviews" : {}
	}, {
		"nom" : "Babola Storm II",
		"reference" : "BABSII",
		"price" : "125.5",
		"description" : "La dernière raquette de babolat",
		"brand" : {
			"nom" : "Babolat",
			"description" : "Equipementier Français"
		},
		"deal" : {},
		"reviews" : {}
	}, {
		"nom" : "Babola Storm II",
		"reference" : "BABSII",
		"price" : "125.5",
		"description" : "La dernière raquette de babolat",
		"brand" : {
			"nom" : "Babolat",
			"description" : "Equipementier Français"
		},
		"deal" : {},
		"reviews" : {}
	} ]
	$scope.deals = [ {
		"description" : "Réduction sur la babolat Storm II",
		"beginning" : "15/05/2013",
		"end" : "18/08/2013",
		"rate" : "0.1",
		"article" : {
			"nom" : "Babola Storm II",
			"reference" : "BABSII",
			"price" : "125.5",
			"description" : "La dernière raquette de babolat",
			"brand" : {
				"nom" : "Babolat",
				"description" : "Equipementier Français"
			},
			"deal" : {},
			"reviews" : {}
		}
	} ];
}
