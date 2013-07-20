describe("Quelques matcher", function(){
	it("Test to be", function(){
		var resultat = 2*4;
		expect(resultat).toBe(8);
	});
	
	it("Test equal", function(){
		var resultat = 2/4;
		expect(resultat).toEqual(0.5);
	});
	
	it("Test not", function(){
		var resultat = "Mathieu";
		expect(resultat).not.toBe("Julie");
	});
	
	it("Test match", function(){
		var resultat = "Mathieu";
		expect(resultat).toMatch(/Mat/);
	}); 
});

describe("After - Before", function() {

	var after = 0;
	var before = 0;
	
	beforeEach(function() {
		before = 1;
	});

	afterEach(function() {
		after = 1;
	});
	
	it("Test after", function(){
		after +=1
		expect(before).toEqual(1);
	}); 
	
	it("Test before", function(){
		before +=1
		expect(before).toEqual(2);
	}); 
});

xdescribe("ma suite désactivé", function(){
	
	xit("Mon test désactivé", function(){
		expect(true).toBeFalsy();
	});
});

describe("test de spy", function(){
	
	var code, bond = null;
	
	beforeEach(function(){
		
		bond = {
				james : function(value){
					code = value;
				}
		};
		
		spyOn(bond,'james');
		
		bond.james(007);
	});
	
	it("Un espion à espionner", function(){
		expect(bond.james).toHaveBeenCalled();
	});
});