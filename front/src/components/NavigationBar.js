import { AppBar, IconButton, Toolbar, Typography, Button } from '@material-ui/core';
import HomeIcon from '@material-ui/icons/Home';
import React from 'react';
import { Link } from 'react-router-dom';
import useStyles from 'styles';

export function NavigationBar() {
  const classes = useStyles();

  return (
    <AppBar position="relative">
      <Toolbar>
        <IconButton color="inherit" component={Link} to="/" className={classes.logoIcon} >
          <HomeIcon />
        </IconButton>
        <Typography variant="h6" color="inherit" component={Link} to="/" noWrap className={classes.title}>
          Itau Test
        </Typography>
        <Button  color="inherit" size="small" component={Link} to="/">
            Estatisticas dos Usuários
        </Button>
        <Button color="inherit" size="small" component={Link} to="/tweets">
            Estatisticas dos Tweets
        </Button>
      </Toolbar>
    </AppBar>
  );
}
