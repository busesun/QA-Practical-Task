import cred from "../fixtures/example.json"

it('Login Scenario', () =>{
    cy.visit(Cypress.config().baseUrl);
    cy.get("#loginForm-eMail").type(cred.email1);
    cy.get('#loginForm-password').type(cred.password1);
    if (Cypress.$(".frc-button").length > 0) {
        cy.get('.frc-button').click()
      } else {
        cy.get('#login-submit-btn', { timeout: 100000 }); //there might be more effective way
       // cy.get('[disabled]').click({force: true})
        cy.get('[data-qa-id="login-form-loginForm-submit-button"]').click()
      }


    }
)