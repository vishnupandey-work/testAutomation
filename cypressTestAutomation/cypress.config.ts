const { defineConfig } = require("cypress");
import * as path from 'path'
import * as fs from 'fs-extra'

module.exports = defineConfig({
  projectId: "xmhkmk",
  reporter: 'cypress-mochawesome-reporter',
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
      require('cypress-mochawesome-reporter/plugin')(on);

      function getConfigurationByFile(filename) {
        const pathToConfigFile = path.resolve('cypress/config', `${filename}.json`)
        return fs.readJSON(pathToConfigFile)
      }

      const file = config.env.configFile || 'default'
      return getConfigurationByFile(file)
    },
    specPattern: "cypress/e2e/**/*.spec.ts"
  },
});
