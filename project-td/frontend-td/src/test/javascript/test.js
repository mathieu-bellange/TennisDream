describe("Mon premier test", function() {
    it("should be 42", function() {
        var resultat = _.max([1, 2, 3, 42]);
        expect(resultat).toBe(42);
    };
};