import cred from "../fixtures/example.json"

it('Login Scenario', () =>{
    cy.visit(Cypress.config().baseUrl);
    cy.get("#loginForm-eMail").type(cred.email);
    cy.get('#loginForm-password').type(cred.password);
    if (Cypress.$(".frc-button").length > 0) { // it is sometimes visible sometimes not, so if exist click or not then click to submit
        cy.get('.frc-button').click()
      } else {
        cy.get('#login-submit-btn', { timeout: 100000 }); //there might be more effective way
       // cy.get('[disabled]').click({force: true})
        cy.get('[data-qa-id="login-form-loginForm-submit-button"]').click()
      }

      cy.get('.o-AccountContent-left-column > :nth-child(1)').contains('.u-padding--left > .a-h3').should('be.visible')  // hallo text

}



)




