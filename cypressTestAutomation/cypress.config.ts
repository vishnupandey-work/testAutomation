const { defineConfig } = require("cypress");
import * as path from 'path'
import * as fs from 'fs'

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
      //require('cypress-moch')
    },
    specPattern:"cypress/e2e/**/*.spec.ts"
  },
});
