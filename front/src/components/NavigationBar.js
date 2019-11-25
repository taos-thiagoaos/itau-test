import { AppBar, IconButton, Toolbar, Typography } from '@material-ui/core';
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
        <Button variant="outlined" size="small">
            Estatisticas dos Usuários
        </Button>
        <Button variant="outlined" size="small">
            Estatisticas dos Tweets
        </Button>
      </Toolbar>
    </AppBar>
  );
}
