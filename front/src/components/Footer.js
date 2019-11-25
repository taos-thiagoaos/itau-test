import React from 'react';
import useStyles from 'styles';
import { Typography } from '@material-ui/core';

export function Footer() {
  const classes = useStyles();

  return (
    <footer className={classes.footer}>
      <Typography
        variant="body2"
        align="center"
        color="textSecondary"
        component="p"
      >
        By Thiago Antonius
      </Typography>
    </footer>
  );
}
