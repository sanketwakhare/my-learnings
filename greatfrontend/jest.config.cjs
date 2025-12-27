module.exports = {
  preset: 'ts-jest',
  testEnvironment: 'jsdom',
  testMatch: ['**/*.test.js', '**/*.test.ts'],
  moduleFileExtensions: ['ts', 'tsx', 'js', 'jsx'],
  transform: {
    '^.+\\.tsx?$': ['ts-jest', { tsconfig: { esModuleInterop: true } }],
    '^.+\\.jsx?$': 'babel-jest',
  },
};
