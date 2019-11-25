import Container from '@material-ui/core/Container';
import CssBaseline from '@material-ui/core/CssBaseline';
import { AppRouter } from 'AppRouter';
import { Footer } from 'components/Footer';
import { NavigationBar } from 'components/NavigationBar';
import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import useStyles from 'styles';
import './App.css';

function App() {
  const classes = useStyles();

  return (
    <React.Fragment>
      <Router>
        <CssBaseline />
        <NavigationBar></NavigationBar>
        <main>
          <Container className={classes.mainContainer} maxWidth="lg">
            <AppRouter></AppRouter>
          </Container>
        </main>
        <Footer></Footer>
      </Router>
    </React.Fragment>
  );
}

export default App;
