describe('myTest', () => {

    it('', () => {
        //cy.visit("https://www.amazon.in")
        //cy.visit('https://www.google.com')
        //cy.wait(10000)
        cy.visit('/')
        cy.get('#username').clear().type('dummyUser')
        cy.get('#password').clear().type('dummyPassword')
        cy.get('#log-in').click()
    })
})